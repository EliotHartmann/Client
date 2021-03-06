import java.time.LocalDateTime;
import java.util.Locale;

public class PolicemanBuilder {
        private int healthPoint;
        private String name;
        private String colour;
        private int age;
        private String describition = "Вооруженные до зубов";
        private int x1;
        private int y1;
        private int height;
        private int width;
        LocalDateTime createTime;


        public PolicemanBuilder name(String name){
            this.name = name;
            return this;
        }
        public PolicemanBuilder colour(String colour){
            this.colour = colour;
            return this;
        }
        public PolicemanBuilder age(int age){
            this.age = age;
            return this;
        }
        public PolicemanBuilder x1(int x1){
            this.x1 = x1;
            return this;
        }

        public PolicemanBuilder y1(int y1){
            this.y1 = y1;
            return this;
        }
        public PolicemanBuilder height(int height){
            this.height = height;
            return this;
        }
        public PolicemanBuilder width(int width){
            this.width = width;
            return this;
        }
    public  PolicemanBuilder createTime(){
        this.createTime = LocalDateTime.now();
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Policeman build(){
            return new Policeman(this);
        }



        public String getName() {
            return name;
        }

        public String getColour() {
            return colour;
        }

        public int getAge() {
            return age;
        }


        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }


