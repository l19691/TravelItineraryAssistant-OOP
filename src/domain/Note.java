package domain;

public class Note {
    private String content;
    private String createdAt;

    public Note(String content, String createdAt) {
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "[" + createdAt + "] " + content;
    }
}
