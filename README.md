# Thread
- 정보 가져오기 (크롤링 맛보기)
```java
EditText urlEdit;
String url = urlEdit.getText().toString();
 AsyncTask<String,String,String> a = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0].contains("http")?strings[0]:"http://"+strings[0]); //url
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                    PrintWriter pw = new PrintWriter(con.getOutputStream());
//                    String protocol[] = {"GET /index HTTP/1.1",
//                            "Host: localhost:8080",
//                            "Cache-Control: no-cache",
//                            "Postman-Token: 8716f735-6daa-792a-edcc-2f6cbbfeea53"
//                            ""};
//                    for(String s : protocol){
//                        pw.println(s);
//                    }
                    Scanner scan = new Scanner(con.getInputStream());
                    StringBuilder sb = new StringBuilder();
//                    scan.next("\\z");  // "\\z" 전체 문자 끝까지 다 가져옴
                    /*
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    for(String s : reader.lines()){
                        Log.e("crawl", s);
                    }
                    */
                    while(scan.hasNext()){
                       sb.append(scan.next());
                    }
                    scan.close();
                    return sb.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onProgressUpdate(String... values) {
            }
            @Override
            protected void onPostExecute(@Nullable String s) {
                resultTxt.setText(s);
            }
        }.execute(url,regex);
    }

```
