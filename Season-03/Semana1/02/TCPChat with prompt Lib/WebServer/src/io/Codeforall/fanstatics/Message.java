package io.Codeforall.fanstatics;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private String content;
    private String sender;
    private final Map<String, String> reactions = new HashMap<>();

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void addReaction(String username, String emoji) {
        reactions.put(username, emoji);
    }

    public String getFormattedMessage() {
        StringBuilder formatted = new StringBuilder(content);
        if (!reactions.isEmpty()) {
            formatted.append(" [Reações: ");
            for (Map.Entry<String, String> entry : reactions.entrySet()) {
                formatted.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            formatted.setLength(formatted.length() - 2); // Remove a última vírgula e espaço
            formatted.append("]");
        }
        return formatted.toString();
    }
}
