import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AmigoSecreto {
    private static final String SENDER_EMAIL = "amigosecretomonteiroteamplus@gmail.com";
    private static final String EMAIL_SUBJECT = "Monteiro Team Plus - Amigo Secreto 2024!";
        // password: jvin skay uves kxay
    private static Properties loadEmailConfig() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            List<Amigo> amigos = coletarInformacoes(scanner);

            if (amigos.size() < 2) {
                System.out.println("É necessário ter pelo menos 2 participantes!");
                return;
            }

            // Solicita a senha do email de forma segura
            Console console = System.console();
            char[] senhaChar;
            if (console != null) {
                senhaChar = console.readPassword("Digite a senha do email (%s): ", SENDER_EMAIL);
            } else {
                System.out.println("Digite a senha do email: ");
                senhaChar = scanner.nextLine().toCharArray();
            }
            String senha = new String(senhaChar);
            Arrays.fill(senhaChar, ' ');

            // Realiza o sorteio
            if (realizarSorteio(amigos)) {
                // Envia os emails e salva o log
                enviarEmails(amigos, senha);
                salvarLog(amigos);
                System.out.println("Sorteio realizado e emails enviados com sucesso!");
            } else {
                System.out.println("Não foi possível realizar o sorteio após várias tentativas.");
            }

        } catch (Exception e) {
            System.err.println("Erro durante a execução do programa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Amigo> coletarInformacoes(Scanner scanner) {
        List<Amigo> amigos = new ArrayList<>();

        System.out.println("Quantos amigos participarão?");
        int quantidade = lerNumeroValido(scanner);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nAmigo " + (i + 1));
            System.out.println("Digite o nome:");
            String nome = scanner.nextLine().trim();

            System.out.println("Digite o email:");
            String email = validarEmail(scanner.nextLine().trim());

            amigos.add(new Amigo(nome, email));
        }

        return amigos;
    }

    private static int lerNumeroValido(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                int num = Integer.parseInt(input);
                if (num > 1) return num;
                System.out.println("Por favor, digite um número maior que 1.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    private static String validarEmail(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            return email;
        } catch (AddressException e) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
    }

    private static boolean realizarSorteio(List<Amigo> amigos) {
        int tentativas = 0;
        int maxTentativas = 100;

        while (tentativas < maxTentativas) {
            List<Amigo> embaralhado = new ArrayList<>(amigos);
            Collections.shuffle(embaralhado);

            boolean valido = true;
            for (int i = 0; i < amigos.size(); i++) {
                if (amigos.get(i).equals(embaralhado.get(i))) {
                    valido = false;
                    break;
                }
            }

            if (valido) {
                for (int i = 0; i < amigos.size(); i++) {
                    amigos.get(i).setAmigoSecreto(embaralhado.get(i));
                }
                return true;
            }

            tentativas++;
        }
        return false;
    }

    private static void enviarEmails(List<Amigo> amigos, String senha) {
        Session session = Session.getInstance(loadEmailConfig(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, senha);
            }
        });

        for (Amigo amigo : amigos) {
            try {
                Message mensagem = new MimeMessage(session);
                mensagem.setFrom(new InternetAddress(SENDER_EMAIL));
                mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(amigo.getEmail()));
                mensagem.setSubject(EMAIL_SUBJECT);

                String corpo = String.format(
                        "Olá %s!\n\n" +
                                "Você foi sorteado(a) para ser o amigo secreto de: %s\n\n" +
                                "Boas festas!\n" +
                                "Monteiro Team Plus",
                        amigo.getNome(),
                        amigo.getAmigoSecreto().getNome()
                );

                mensagem.setText(corpo);
                Transport.send(mensagem);

                System.out.println("Email enviado com sucesso para: " + amigo.getEmail());
                Thread.sleep(1000); // Pequena pausa entre envios

            } catch (MessagingException | InterruptedException e) {
                System.err.println("Erro ao enviar email para " + amigo.getEmail() + ": " + e.getMessage());
            }
        }
    }

    private static void salvarLog(List<Amigo> amigos) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
        String filename = "sorteio_" + timestamp + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Log do Sorteio - " + timestamp);
            writer.println("----------------------------------------");

            for (Amigo amigo : amigos) {
                writer.printf("%s (%s) -> %s%n",
                        amigo.getNome(),
                        amigo.getEmail(),
                        amigo.getAmigoSecreto().getNome()
                );
            }

            System.out.println("Log salvo em: " + filename);

        } catch (IOException e) {
            System.err.println("Erro ao salvar o log: " + e.getMessage());
        }
    }
}