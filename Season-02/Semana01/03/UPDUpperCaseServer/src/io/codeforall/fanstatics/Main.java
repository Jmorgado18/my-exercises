package io.codeforall.fanstatics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws IOException {

        int localPort = 8080;
        // Este será o número da porta onde o socket irá escutar.

        DatagramSocket socket = new DatagramSocket(localPort);
        // Cria um socket de datagrama (UDP) vinculado à porta local especificada.
        // Este socket permitirá enviar e receber pacotes de dados na porta 8080.

        while (true) {
            // Inicia um loop infinito, que fará com que o programa continue a escutar e processar pacotes indefinidamente.

            byte[] recvBuffer = new byte[1024];
            // Cria um array de bytes chamado 'recvBuffer' com 1024 posições.
            // Este buffer será usado para armazenar os dados recebidos.

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            // Cria um pacote de datagrama chamado 'receivePacket', que usará 'recvBuffer' para armazenar os dados recebidos.
            // O tamanho do pacote será o comprimento do buffer (1024 bytes).

            socket.receive(receivePacket);
            // O socket aguarda (bloqueia) até receber um pacote.
            // Quando um pacote é recebido, os dados são armazenados no 'receivePacket'.

            String uppercase = new String(recvBuffer, 0, receivePacket.getLength()).toUpperCase();
            // Converte os dados recebidos (armazenados em 'recvBuffer') numa string,
            // usando apenas os bytes válidos (do início até o tamanho do pacote recebido).
            // Em seguida, converte a string para letras maiúsculas.

            byte[] sendBuffer = uppercase.getBytes();
            // Converte a string em letras maiúsculas de volta para um array de bytes chamado 'sendBuffer'.
            // Este array será enviado como resposta.

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            // Cria um novo pacote de datagrama para enviar os dados.
            // Este pacote conterá os dados em 'sendBuffer' e será enviado para o endereço e porta de origem do pacote recebido.

            socket.send(sendPacket);
            // Envia o pacote criado ('sendPacket') de volta ao remetente.
            // Isso devolve a resposta ao cliente que enviou o pacote original.
        }


    }
}
