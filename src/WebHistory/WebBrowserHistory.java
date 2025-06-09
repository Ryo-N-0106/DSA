package WebHistory;

import java.util.Stack;

public class WebBrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public WebBrowserHistory() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = null;
    }

    // Truy cập trang mới
    public void visitPage(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        forwardStack.clear();
        currentPage = url;
    }

    // Quay lại trang trước (Back)
    public String back() {
        if (backStack.isEmpty()) {
            return null;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    // Tiến tới trang đã Back (Forward)
    public String forward() {
        if (forwardStack.isEmpty()) {
            return null;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    // Lấy trang hiện tại
    public String getCurrentPage() {
        return currentPage;
    }
}
