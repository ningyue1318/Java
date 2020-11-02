package com.syn.bibiCourse.ext;

import org.springframework.context.annotation.*;

/*
     AOP原理【看给容器中注册了什么组件，该组件有什么功能，什么时候工作】
        @Import(AspectJAutoProxyRegistrar.class)
            利用AspectJAutoProxyRegistrar自定义给容器中注册bean
            internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
        给容器中注册一个AnnotationAwareAspectJAutoProxyCreator

        AnnotationAwareAspectJAutoProxyCreator
            ->AspectJAwareAdvisorAutoProxyCreator
                ->AbstractAdvisorAutoProxyCreator
                    ->AbstractAdvisorAutoProxyCreator
                        ->AbstractAutoProxyCreator
                            ->implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware

        AbstractAutoProxyCreator.setBeanFactory()
        AbstractAutoProxyCreator有后置处理器的逻辑

        AbstractAdvisorAutoProxyCreator.setBeanFactory()->initBeanFactory()

        AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()


        1.传入配置类，创建ioc容器
        2.注册配置类，调用refresh()刷新容器
        3.registerBeanPostProcessors(beanFactory);注册bean的后置处理器方便拦截bean的创建
            3.1 先获取ioc容器已经定义的需要创建对象的所有BeanPostProcessor
            3.2 给容器加别的BeanPostProcessor
            3.3 优先注册实现了PriorityOrdered接口的BeanPostProcessor
            3.4 在给容器注册实现了Ordered接口的BeanPostProcessor
            3.5 没有实现注册借口的BeanPostProcessor
            3.6 注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
                创建internalAutoProxyCreator的BeanPostProcessor[AnnotationAwareAspectJAutoProxyCreator]
                1>创建Bean的实例
                2>populateBean属性赋值
                3>initializeBean初始化Bean
                    invokeAwareMethods()处理Aware接口的调用
                    applyBeanPostProcessorsBeforeInitialization(),应用后置处理器的BeforeInitialization方法
                    invokeInitMethods方法
                    applyBeanPostProcessorsAfterInitialization()
                4>BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功
            3.7 把BeanPostProcessor注册到BeanFactory中
                beanFactory.addBeanPostProcessor(postProcessor)
   ================================创建和注册的过程====================================
        4.finishBeanFactoryInitialization(beanFactory)完成BeanFactory初始化工作，创建剩下的单实例Bean
            4.1 遍历获取容器中的所有Bean，依次创建对象getBean(beanName)
                getBean->doGetBean->getSingleton
            4.2 创建bean
                先从缓存中获取当前bean，如果能获取到，说明bean之前被创建过，直接使用，否则在创建
                createBean()
                    resolveBeforeInstantiation,希望后置处理器能返回一个代理对象，如果能返回代理对象就使用，如果不能就继续

                    doCreateBean()真正去创建一个bean,和3.6流程一样
            AnnotationAwareAspectJAutoProxyCreator[InstantiationAwareBeanProcessor]的作用
            1 每一个bean创建之前，调用postProcessBeforeInstantiation()
                关心MathCalculator和LogAspect的创建
                1.判断当前bean是否存在advisedBeans中（保存了需要增强的bean）
                2.判断当前bean是否是基础类型的Advice，Pointcut,AopInfrastructureBean，或者是否是切面
                3.是否需要跳过
                    1获取候选的增强器（切面里面的通知方法）List<Advisor> candidateAdvisors
                    每一个封装通知方法的增强器InstantiationModeAwarePointcutAdvisor
                    判断每一个增强器是否是AspectJPointcutAdvisor类型，返回true
                    永远返回false
             2 postProcessAfterInstantiation()
                    wrapIfNecessary(bean,beanName,cacheKey);
                    1 获取能在当前bean使用的所有增强器（通知方法）object[] specificInterceptors
                        找到候选的所有bean的增强器（找到那些方法是需要切入当前bean方法的）
                        获取到能在bean使用的增强器
                        给增强器排序
                    2 保存当前bean在advisedBeans中
                    3 如果当前bean需要增强，创建当前bean的代理对象
                        获取所有的增强器（通知方法）
                        保存到proxyFactory中
                        创建代理对象
                            JdkDynamicAopProxy（config）JDK动态代理
                            ObjenesisCglibAopProxy(config) cglib动态代理
                    4 给容器返回当前组件使用cglib增强了的代理对象
                    5 容器中获取的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行
            3 目标方法执行
                容器中保存了组件的代理对象(cglib增强后的对象)，这个对象里面保存了详细的信息（比如增强器，目标对象，xxx）
                CglibAopProxy.intercept()方法，拦截目标方法的执行
                根据ProxyFactory对象获取拦截器链
                    List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice
                    1 List<Object> interceptorList保存所有的拦截器
                    2 遍历所有的增强器，将其转为Interceptor
                        registry.getInterceptors(advisor)
                    3 将增强器转为List<MethodInterceptor>
                        如果是MethodInterceptor，直接加入到结合中
                        如果不是，使用AdvisorAdapter将增强器转为MethodInterceptor
                        转换完成返回MethodInterceptor数组

                如果没有拦截器链，直接执行目标方法
                如果有拦截器链，把需要执行的目标对象，目标方法，拦截器链等信息传入创建一个CglibMethodInvocation
                    并调用Object retVal = mi.proceed()方法
                拦截器链的触发过程
                    如果没有拦截器执行目标方法，或者拦截器的索引和拦截器数组-1大小一样（执行最后一个拦截器）
                    链式获取每一个拦截器，拦截器执行invoke方法，每一个拦截器等待下一个拦截器执行完成返回以后再来执行
                    拦截器的机制，保证通知方法与目标方法的执行顺序







 */
@Configuration
@ComponentScan(basePackages = "com.syn.bibiCourse.ext")
@EnableAspectJAutoProxy
public class MainConfigOfAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator calculator = ac.getBean(MathCalculator.class);
        calculator.div(1,1);
    }
}
