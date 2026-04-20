/**
 * EnergyCalculator 作为策略模式上下文，委托当前策略完成能耗计算。
 */
public class EnergyCalculator {
    private EnergyStrategy energyStrategy;

    public EnergyCalculator(EnergyStrategy energyStrategy) {
        this.energyStrategy = energyStrategy;
    }

    public void setEnergyStrategy(EnergyStrategy energyStrategy) {
        this.energyStrategy = energyStrategy;
    }

    public void printConsumption(double baseConsumption) {
        double result = energyStrategy.calculateEnergyConsumption(baseConsumption);
        System.out.printf("使用%s，基础能耗 %.2f kWh -> 实际能耗 %.2f kWh%n",
                energyStrategy.getStrategyName(), baseConsumption, result);
    }
}
