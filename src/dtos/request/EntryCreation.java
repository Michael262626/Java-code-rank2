package dtos.request;

public class EntryCreation {
        private String title;
        private String body;
        public EntryCreation(String title,String body){
            this.title = title;
            this.body = body;
        }

    public EntryCreation() {

    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

    }


