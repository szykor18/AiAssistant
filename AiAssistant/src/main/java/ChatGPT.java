import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;


public class ChatGPT {
    OpenAiService service;
    public ChatGPT() {
        service = new OpenAiService("************************", Duration.ofSeconds(30));
    }
    public String getBreakfastRecipes(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "Mam w lodówce " + allProducts + ". Co mogę zrobić na śniadanie? Daj mi trzy pomysły";
        return askChatGPT(question);
    }
    public String getDinnerRecipes(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "Mam w lodówce " + allProducts + ". Co mogę zrobić na obiad? Daj mi trzy pomysły";
        return askChatGPT(question);
    }
    public String getSupperRecipes(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "Mam w lodówce " + allProducts + ". Co mogę zrobić na kolację? Daj mi trzy pomysły";
        return askChatGPT(question);
    }
    public String getHealthyProducts(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "Mam w lodówce " + allProducts + ". Co zdrowego mogę dokupić? Podaj 3 produkty";
        return askChatGPT(question);
    }
    private String askChatGPT(String question) {
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(List.of(new ChatMessage("user", question)))
                .model("gpt-3.5-turbo")
                .build();
        List<ChatCompletionChoice> choices = service.createChatCompletion(request).getChoices();

        StringBuilder stringBuilder = new StringBuilder();

        choices.stream()
                .map(ChatCompletionChoice::getMessage)
                .map(ChatMessage::getContent)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

}
