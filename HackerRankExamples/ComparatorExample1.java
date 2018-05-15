/*

Implement the Checker class that extends the Comparator class

Input:
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

Output:
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/

import java.util.*;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score > p2.score) {
            return -1;
        } else if (p1.score < p2.score) {
            return 1;
        } else {
            int order = p1.name.compareTo(p2.name);
            if (order > 0) {
                return 1;
            } else if (order < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

class Player {
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class ComparatorExample1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}