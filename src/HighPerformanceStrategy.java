/**
 * HighPerformanceStrategy 代表高性能模式，提升设备输出并增加能耗。
 */
public class HighPerformanceStrategy implements EnergyStrategy {
    @Override
    public double calculateEnergyConsumption(double baseConsumption) {
        return baseConsumption * 1.30;
    }

    @Override
    public String getStrategyName() {
        return "高性能策略";
    }
}
