/**
 * PartyState 表示派对状态下的按钮行为。
 */
public class PartyState implements HomeState {
    @Override
    public void handle(SmartHomeContext context) {
        System.out.println("[派对模式] 打开彩灯与音乐联动效果。");
    }

    @Override
    public String getName() {
        return "派对模式";
    }
}
