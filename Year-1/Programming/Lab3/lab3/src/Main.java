public class Main {
    public static void main(String[] args) throws InvalidTypeException {
        Human[] HumanArray = new Human[0];
        Door door = new Door("Дверь");
        Human chel = new Human("чел");
        Place floor = new Place("Грязный пол");
        Place shadystreet = new Place("Узенький переулок");
        Place street = new Place("Улица");
        Place.Furniture furniture0 = new Place.Furniture("Высокие шкафы");
        Place.Furniture furniture1 = new Place.Furniture("Дубовый Стол");
        Place.Furniture furniture2 = new Place.Furniture("Фотографический автомат");
        Place.Furniture furniture3 = new Place.Furniture("Рентгеновский аппарат");
        Place.Furniture furniture4 = new Place.Furniture("Штафирка");
        Place.Furniture furniture5 = new Place.Furniture("Телефонный аппарат");
        Place.Furniture furniture6 = new Place.Furniture("Ящик с чистыми бланками");
        Place.Furniture furniture7 = new Place.Furniture("Плоаская коробка с краской");

        Place outside = new Place("Открытый воздух");
        Place policedept = new Place("Полицейское управление");
        Place miglworkplace = new Place("Плохо проветриваемое помещение",
                new Place.Furniture[]{furniture0, furniture1, furniture2, furniture3, furniture4, furniture5, furniture6, furniture7});
        Car car = new Car("Автомобиль");
        Chauffeur vodila = new Chauffeur("Водитель");
        Midget neznayka = new Midget("Незнайка");
        Policeman figl = new Policeman("Фигль", Type.Shiny,Hat.Shiny, outside );
        Policeman migl = new Policeman("Мигль", Type.Greasy,Hat.NotShiny, miglworkplace);

        try {
            Place mesto = new Place("");
        } catch (NameError ignored){}


        try {
            Human.dissolve(HumanArray);
        } catch (InvalidTypeException e){
            System.out.println(e.getMessage());

        }

        figl.bear(neznayka, street);
        figl.move(shadystreet);
        figl.stop(car);
        figl.open(car);
        car.openDoor();
        figl.speak("", neznayka);
        figl.bump(neznayka);
        figl.close(car);
        car.closeDoor();
        neznayka.rise(floor);
        neznayka.drumm(door);
        figl.speak("", neznayka);
        figl.enterCar(car);
        figl.speak("Скомандовал", vodila);
        Car.engine.rev();
        vodila.drive(car);
        neznayka.move(policedept);
        figl.Pickup(neznayka, migl);
        figl.getUniform();
        migl.getUniform();
        figl.getWorkplace();
        migl.getWorkplace();
        miglworkplace.describeFurniture();
        migl.getHat();
        figl.getHat();

        if (migl.getClass() == figl.getClass()){
            System.out.println("При этом обнаружилось еще и то, что между Миглем и Фиглем было большое сходство: оба были скуластые, широколицые, у обоих были низкие лбы и темные, жесткие, подстриженные ежиком волосы, начинавшиеся чуть ли не от самых бровей.");
        }


    }
    }