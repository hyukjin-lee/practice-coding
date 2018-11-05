package algorithm.zi;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondNumber2 {

    public String solution(String photos) throws ParseException {
        List<Photo> photoList = new ArrayList<>();
        List<Photo> sortedPhotoList = new ArrayList<>();

        String[] photoArray = photos.split("\n");

        for (String photo : photoArray) {
            String[] fileInfos = photo.split(",");
            fileInfos[0] = fileInfos[0].trim().split("\\.")[1];  // regex 쓸 때 문법 조심! 특히 '.' 같은 경우 특정 역할을 수행한다
            fileInfos[1] = fileInfos[1].trim();

            System.out.println(fileInfos[0]);

            Date newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fileInfos[2]);
            photoList.add(new Photo(fileInfos[0], fileInfos[1], newDate));
        }

        return "원숭이";

    }

    @Test
    public void solutionTest() throws ParseException {
        assertThat(solution("photo.jpg, whara, 2018-03-20 14:08:15"), is("원숭이"));
    }

    private class Photo {
        private String fileName;
        private String cityName;
        private Date date;

        public Photo(String fileName, String cityName, Date date) {
            this.fileName = fileName;
            this.cityName = cityName;
            this.date = date;
        }

        public Photo compareDate(Photo photo1, Photo photo2) {
            int compare = photo1.getDate().compareTo(photo2.getDate());

            if (compare == -1) {
                return photo2;
            } else if (compare == 1) {
                return photo1;
            }

            return photo1;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Photo photo = (Photo) o;
            return Objects.equals(fileName, photo.fileName) &&
                    Objects.equals(cityName, photo.cityName) &&
                    Objects.equals(date, photo.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fileName, cityName, date);
        }
    }
}
