package smarthome.strategy;

/**
 * 具体策略：节能模式，降低单位时间功耗。
 */
public class EcoStrategy implements EnergyStrategy {
    @Override
    public double calculateEnergyConsumption(double basePowerKw, int hours) {
        return basePowerKw * 0.75 * hours;
    }

    @Override
    public String name() {
        return "节能模式";
    }
}
