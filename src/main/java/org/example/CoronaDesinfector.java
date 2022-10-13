package org.example;

public class CoronaDesinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);


    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Заканичваем дезинфекцию");
    }

    private void desinfect(Room room) {
        System.out.println("Изыди корона");
    }
}
