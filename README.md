# Thread

```java
EditText urlEdit;
String url = urlEdit.getText().toString();

URL url = new URL(strings[0].contains("http")?strings[0]:"http://"+strings[0]); //url
HttpURLConnection con = (HttpURLConnection) url.openConnection();
Scanner scan = new Scanner(con.getInputStream());
StringBuilder sb = new StringBuilder();
// scan.next("\\z");  // "\\z" 전체 문자 끝까지 다 가져옴
```
