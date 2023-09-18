public class Main {
    public static void main(String[] args) {
        Place outside = new Place("Открытый воздух");
        Place policedept = new Place("Полицейское управление");
        Place miglworkplace = new Place("Плохо проветриваемое помещение");
        Car car = new Car("Автомобиль");
        Chauffeur vodila = new Chauffeur("Водитель");
        Midget neznayka = new Midget("Незнайка");
        Policeman figl = new Policeman("Фигль", Type.Shiny, outside );
        Policeman migl = new Policeman("Мигль", Type.Greasy, miglworkplace);

        figl.speak("Ничего", neznayka);
        figl.enterCar(car);
        figl.speak("Скомандовал", vodila);
        car.rev();
        vodila.drive(car);
        neznayka.move(policedept);
        figl.Pickup(neznayka, migl);
        figl.getUniform();
        migl.getUniform();
        figl.getWorkplace();
        migl.getWorkplace();

    }
    }