package smarthome.strategy;

/**
 * 具体策略：自定义模式，允许外部传入倍率调整能耗。
 */
public class CustomStrategy implements EnergyStrategy {
    private final double factor;

    public CustomStrategy(double factor) {
        this.factor = factor;
    }

    @Override
    public double calculateEnergyConsumption(double basePowerKw, int hours) {
        return basePowerKw * factor * hours;
    }

    @Override
    public String name() {
        return "自定义模式(" + factor + "x)";
    }
}
