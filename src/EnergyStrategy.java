/**
 * EnergyStrategy 定义能耗计算策略接口。
 * 客户端可以在运行时切换不同算法。
 */
public interface EnergyStrategy {
    double calculateEnergyConsumption(double baseConsumption);

    String getStrategyName();
}
