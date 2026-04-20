package smarthome.strategy;

/**
 * 具体策略：高性能模式，提高设备运行功率。
 */
public class HighPerformanceStrategy implements EnergyStrategy {
    @Override
    public double calculateEnergyConsumption(double basePowerKw, int hours) {
        return basePowerKw * 1.30 * hours;
    }

    @Override
    public String name() {
        return "高性能模式";
    }
}
