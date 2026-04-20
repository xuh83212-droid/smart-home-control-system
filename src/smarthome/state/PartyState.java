package smarthome.state;

/**
 * 具体状态：派对模式下，按键触发音乐和氛围灯效果。
 */
public class PartyState implements SmartHomeState {
    @Override
    public void triggerAction() {
        System.out.println("[派对模式] 开启音乐、彩灯与空调强劲送风。");
    }

    @Override
    public String getStateName() {
        return "派对模式";
    }
}
