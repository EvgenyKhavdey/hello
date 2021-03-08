package model;

public class Cat {
    private String nickname;
    private int force;

    public Cat(String nickname, int force){
        this.nickname = nickname;
        this.force = force;
    }
    public void run(int x){
        int y = x - force;
        if (y > 0){
            System.out.println("У " + nickname + " не хватило сил пробежать дорожку" );
            return;
        }
        System.out.println(nickname + " пробежал дорожку");
    }

    public void bounce(float x){
        if (x >= 1.1){
            System.out.println("Стена слишком высокая " + nickname + " не может перепрыгнуть");
            return;
        }
        System.out.println(nickname + " перепрыгнул стену");
    }
}


