package quotes;

public class QuotesApi {
    private String quoteText;
    private String quoteAuthor;

    public QuotesApi(String author, String text){
        this.quoteText = author;
        this.quoteAuthor = text;
    }

    public String getQuotesText() {
        return quoteText;
    }

    public void setQuotesText(String author) {
        this.quoteText = author;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String text) {
        this.quoteAuthor = text;
    }

    @Override
    public String toString() {
        return "QuotesApi{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
