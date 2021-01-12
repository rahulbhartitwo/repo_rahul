package com.kreate.daggerwithhilt.entity.response;

public class ModelRecentSearch  {

        private String title;

        private String time;

        private String readingTime;

        private Integer image;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getReadingTime() {
            return readingTime;
        }

        public void setReadingTime(String readingTime) {
            this.readingTime = readingTime;
        }

        public Integer getImage() {
            return image;
        }

        public void setImage(Integer image) {
            this.image = image;
        }

        public ModelRecentSearch(String title, String time, Integer image) {
            this.title = title;
            this.time = time;
            this.image = image;
        }
}