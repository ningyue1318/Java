package Builder;

/*
    应用场景：类有多个参数需要创建的时候配置。

    实现方式1.0：
        将所有参数集中在构造函数中，完成类的创建。

        缺点：构造函数列表过长，可能出现遗漏


    实现方式2.0：
        将必要参数放进构造函数中，其他参数通过set方法设置。

        缺点：必要参数不能过长，都这会出现上面的问题。有依赖关系的时候，，set的无法做逻辑验证。


    实现方式3.0：
        用建造者模式构造对象，可以在Build方法内做参数间的关系验证，在set方法内做本参数验证，如是否为空等。

        缺点：需要额外编写Builder类代码。
 */

public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder){
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder{
        private static final  int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build(){
            if(maxIdle>maxTotal){
                throw new IllegalArgumentException("...");
            }
            if(minIdle>maxIdle||minIdle>maxIdle){
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name){
            //可以加一些必要的校验逻辑
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal){
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle){
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle){
            this.minIdle = minIdle;
            return this;
        }

    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMaxIdle(10)
                .setMinIdle(8)
                .build();
    }
}
