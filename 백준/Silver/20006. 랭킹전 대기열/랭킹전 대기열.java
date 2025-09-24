import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Room> rooms = new ArrayList<>();

    while (p-- > 0) {
      st = new StringTokenizer(br.readLine());
      Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
      boolean flag = false;

      for (Room room : rooms) {
        if (room.isEnter(member.level, m)) {
          room.enter(member);
          flag = true;
          break;
        }
      }

      if (!flag) {
        Room room = new Room();
        room.enter(member);
        rooms.add(room);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Room room : rooms) {
      // 정렬 신기하네...
      room.members.sort(Comparator.comparing(member -> member.name));
      sb.append(room.size < m ? "Waiting!" : "Started!").append("\n");
      for (Member member : room.members) {
        sb.append(member.level).append(" ").append(member.name).append("\n");
      }
    }

    System.out.print(sb);
  }
}

class Member {

  public Member(int level, String name) {
    this.level = level;
    this.name = name;
  }

  int level;
  String name;
}

class Room {

  ArrayList<Member> members = new ArrayList<>();
  int minLevel;
  int maxLevel;
  int size;

  boolean isEnter(int l, int m) {
    return size < m && l >= minLevel && l <= maxLevel;
  }

  void enter(Member member) {
    if (size == 0) {
      minLevel = member.level - 10;
      maxLevel = member.level + 10;
    }
    members.add(member);
    size++;
  }
}
