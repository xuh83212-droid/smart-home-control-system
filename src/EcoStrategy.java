/**
 * EcoStrategy 代表节能模式，降低基础能耗。
 */
public class EcoStrategy implements EnergyStrategy {
    @Override
    public double calculateEnergyConsumption(double baseConsumption) {
        return baseConsumption * 0.75;
    }

    @Override
    public String getStrategyName() {
        return "节能策略";
    }
}
