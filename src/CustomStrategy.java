/**
 * CustomStrategy 允许通过自定义系数动态计算能耗。
 */
public class CustomStrategy implements EnergyStrategy {
    private final double factor;

    public CustomStrategy(double factor) {
        this.factor = factor;
    }

    @Override
    public double calculateEnergyConsumption(double baseConsumption) {
        return baseConsumption * factor;
    }

    @Override
    public String getStrategyName() {
        return "自定义策略(" + factor + "x)";
    }
}
