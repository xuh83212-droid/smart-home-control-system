package smarthome.strategy;

/**
 * Strategy 抽象策略：定义统一能耗计算算法入口。
 */
public interface EnergyStrategy {
    double calculateEnergyConsumption(double basePowerKw, int hours);

    String name();
}
