import java.io.*; // Importa as classes necessárias para trabalhar com I/O (Input/Output)
import java.net.ServerSocket; // Importa a classe ServerSocket, que permite criar um servidor
import java.net.Socket; // Importa a classe Socket, que permite a comunicação com clientes

public class Main {
    public static void main(String[] args) throws IOException {

        // Cria um servidor na porta 5000
        ServerSocket socket = new ServerSocket(5000);


        while (true) {
            try (Socket clientSocket = socket.accept()) {
                // Configura um objeto PrintWriter para enviar dados de saída ao cliente (escrita)
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // Configura um BufferedReader para receber dados do cliente (leitura)
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // Obtém o OutputStream para enviar dados ao cliente
                OutputStream outputStream = clientSocket.getOutputStream();

                // Lê a linha de entrada do cliente e toma ações com base no conteúdo
                switch (in.readLine()) {


                    case "GET /logo.png HTTP/1.1":
                        // Cria um array de bytes para armazenar os dados do arquivo
                        byte[] bytes = new byte[5000];
                        // Lê o arquivo "logo.png" do diretório "www"
                        FileInputStream inputStream = new FileInputStream("www/logo.png");
                        // Lê o arquivo e armazena o número de bytes lidos
                        int bytesread = inputStream.read(bytes);
                        // Envia a resposta HTTP para o cliente
                        out.println("HTTP/1.0 200 Document Follows\r\n " +
                                "Content-Type: image/www/logo.png \r\n\" " +
                                "Content-Length:" + bytesread + " \r\n");
                        // Envia os dados do arquivo para o cliente
                        outputStream.write(bytes, 0, bytesread);
                        break;

                    // Caso o cliente peça o arquivo "index.html"
                    case "GET /index.html HTTP/1.1":
                        // Cria um array de bytes para armazenar os dados do arquivo
                        bytes = new byte[5000];
                        // Lê o arquivo "index.html" do diretório "www"
                        inputStream = new FileInputStream("www/index.html");
                        // Lê o arquivo e armazena o número de bytes lidos
                        bytesread = inputStream.read(bytes);
                        // Envia a resposta HTTP para o cliente
                        out.println("HTTP/1.0 200 Document Follows\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n" +
                                "Content-Length:" + bytesread + "\r\n");
                        // Envia os dados do arquivo para o cliente
                        outputStream.write(bytes, 0, bytesread);
                        break;

                    // Caso o cliente peça um arquivo que não existe
                    default:
                        // Cria um array de bytes para armazenar os dados do arquivo "404.html"
                        bytes = new byte[5000];
                        // Lê o arquivo "404.html" do diretório "www"
                        inputStream = new FileInputStream("www/404.html");
                        // Lê o arquivo e armazena o número de bytes lidos
                        bytesread = inputStream.read(bytes);
                        // Envia a resposta HTTP para o cliente
                        out.println("HTTP/1.0 404 Not Found\r\n " +
                                "Content-Type: text/html; charset=UTF-8\r\n " +
                                "Content-Length: " + bytesread + " \r\n");
                        // Envia os dados do arquivo para o cliente
                        outputStream.write(bytes, 0, bytesread);
                        break;
                }
            }
        }
    }

}