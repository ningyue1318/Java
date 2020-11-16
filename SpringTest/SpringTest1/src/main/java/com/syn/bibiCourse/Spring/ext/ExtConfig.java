package com.syn.bibiCourse.Spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
  1.BeanPostProcessor:bean的后置处理器，bean创建对象初始化前后进行拦截操作
  BeanFactoryPostProcessor:beanFactory后置处理器，在标准初始化之后操作，所有的bean定义已经加载到beanFactory
    1>ioc容器创建对象
    2>invokeBeanFactoryPostProcessors(BeanFactory);执行BeanFactoryPostProcessor
        找到所有的BeanFactoryPostProcessor并执行他们的方法
            -直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor组件，并执行他们的方法。
            -在初始化其他组件前面执行。

  2.BeanDefinitionRegistryPostProcessor
    postProcessBeanDefinitionRegistry()在所有的Bean定义信息将要被加载，Bean实例还未创建。
    优先于BeanPostProcessor执行，利用postProcessBeanDefinitionRegistry()可以给容器再加入bean

  3.ApplicationListener:监听容器中发布的事件，事件驱动模型的开发。
    ApplicationListener<E extends ApplicationEvent>
        监听ApplicationEvent及其下面的子事件
        步骤: 1>写一个监听器来监听某个事件(ApplicationEvent及其子类)
              2>把监听器加入到容器中
              3>只要容器中有相关的事件发布，就能监听到这个事件
              4>发布事件publishEvent()
        原理:ContextRefreshedEvent,自定义事件，ContextClosedEvent
            1>ContextRefreshedEvent事件发布流程
                1.1 调用refresh()方法
                1.2 调用finishRefresh()方法
                【事件发布流程】
                1.3 publishEvent()方法(里面是ContextRefreshedEvent对象)
                    1.3.1 获取事件的多播器():getApplicationEventMulticaster()
                    1.3.2 multicastEvent派发事件
                        for(final ApplicationListener<?> listener:getApplicationListeners(event,type))
                            如果有Executor，可以执行Executor进行异步派发
                            否则执行listener方法，invokeListener方法
                        拿到listener回调onApplicationEvent方法

             2>如何获取事件多播器
                2.1 调用refresh()方法
                2.2 initApplicationEventMulticaster()方法
                    2.2.1 先在容器中找有没有id="applicationEventMulticaster"的组件
                    2.2.2 若没有创建this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(),并且加入到容器中
                          如果在其他组件要派发事件，自动注入applicationMulticaster

             3>容器中有那些监听器
                3.1 调用refresh方法
                3.2 registerListeners()，从容器中拿到所有的监听器，并把他们注册到applicationEventMulticaster中
                    String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class,true,false);

 */

/*
    1.prepareRefresh()方法
        1.1 initPropertySources(),初始化一些属性设置，子类自定义个性化的属性设置方法。
        1.2 getEnvironment().validateRequiredProperties(),检验属性的合法等。
        1.3 earlyApplicationEvents = new LinkedHashSet<ApplicationEvent>()保存容器中的一些早期事件。
    2.obtainFreshBeanFactory(),获取BeanFactory,
        2.1 refreshBeanFactory(),刷新BeanFactory
            创建了一个this.beanFactory = new DefaultListableBeanFactory();
            设置Id，
        2.2 getBeanFactory(),返回刚才GenericApplicationContext创建的BeanFactory对象
    3.prepareBeanFactory(beanFactory),BeanFactory的预准备工作
        3.1 设置BeanFactory的类加载器，表达式解析器
        3.2 添加部分BeanPostProcessor[ApplicationContextAwareProcessor]
        3.3 设置自动忽略的接口
        3.4 注册可以解析的自动装配，可以在任何组件中自动注入：BeanFactory,ResourceLoader,ApplicationEventPublisher,ApplicationContext
        3.5 添加BeanPostProcessor
        3.6 添加编译时的AspectJ
        3.7 给BeanFactory中注册一些能用的组件，
    4.postProcessBeanFactory(beanFactory) BeanFactory准备工作完成后进行的后置处理工作
        4.1 子类通过重写这个方法来在BeanFactory创建并预备完成以后做进一步的设置

  =====================================BeanFactory的创建和预准备工作================================================================
    5.invokeBeanFactoryPostProcessors(beanFactory),执行BeanFactoryPostProcessor
        BeanFactoryPostProcessor,BeanFactory的后置处理器，在BeanFactory标准初始化执行
        5.1 执行invokeBeanFactoryPostProcessors方法
            【先处理BeanDefinitionRegistryPostProcessor】
            5.1.1 获取所有的BeanDefinitionRegistryPostProcessor
            5.1.2 先执行实现了PriorityOrdered优先级接口的BeanDefinitionRegistryPostProcessor
            5.1.3 再执行了Ordered接口的BeanDefinitionRegistryPostProcessor
            5.1.4 最后执行没有实现任何优先级或者顺序接口的BeanDefinitionRegistryPostProcessor
            【在处理BeanFactoryPostProcessor】
            5.1.5 获取所有的BeanFactoryPostProcessor
            5.1.6 先执行实现了PriorityOrdered优先级接口的BeanFactoryPostProcessor
            5.1.7 再执行了Ordered接口的BeanFactoryPostProcessor
            5.1.8 最后执行没有实现任何优先级或者顺序接口的BeanFactoryPostProcessor
    6.registerBeanPostProcessors(beanFactory),注册BeanPostProcessor
            BeanPostProcessor
            DestructionAwareBeanPostProcessor
            InstantiationAwareBeanPostProcessor
            SmartInstantiationAwareBeanPostProcessor
            MergedBeanDefinitionPostProcessor
        6.1 获取所有的BeanPostProcessor,后置处理器默认可以通过PriorityOrdered,Ordered接口来执行优先级
        6.2 先注册PriorityOrdered优先级接口的BeanPostProcessor,添加到BeanFactory中，
            BeanFactory.addBeanPostProcessor(postProcessor);
        6.3 后注册Ordered优先级接口的BeanPostProcessor,添加到BeanFactory中
        6.4 最后注册没有任何优先级接口的BeanPostProcessor,添加到BeanFactory中
        6.5 最终注册MergedBeanDefinitionPostProcessor
        6.6 注册一个ApplicationListenerDetector,来在Bean创建完成后检查是否是ApplicationListener
   7.initMessageSource(),初始化MessageSource组件（做国际化功能，消息绑定，消息解析）
        7.1 获取BeanFactory
        7.2 查看是否有id为messageSource的组件，如果有赋值给messageSource属性，没有自己创建一个
        7.3 把创建好的MessageSource注册在容器中，获取国际化配置文件的时候，可以自动注册MessageSource
   8.initApplicationEventMulticaster()初始化事件派发器。
        8.1 获取BeanFactory
        8.2 从BeanFactory中提取applicationEventMulticaster的ApplicationEventMulticaster
        8.3 如果上一步没有配置，创建一个SimpleApplicationEventMulticaster
        8.4 将创建的组件添加到BeanFactory中，以后其他组件可以直接自动注入
   9.onRefresh()方法，留给子类重写在容器刷新的时候可以自定义逻辑
   10.registerListeners(),给容器中的所有ApplicationListener注册进来
        10.1 从容器中拿到所有的ApplicationListener
        10.2 将每个监听器都添加到事件派发器中
        10.3 派发之前步骤产生的事件
   11.finishBeanFactoryInitialization(beanFactory)初始化所有剩下的单实例bean
        11.1 beanFactory.preInstantiateSingletons();
            11.1.1 获取容器中的所有Bean，依次进行初始化和创建对象
            11.1.2 获取Bean的定义信息，RootBeanDefinition
            11.1.3 Bean不是抽象的，是单实例的，是懒加载的
                判断是不是FactoryBean，是否是实现FactoryBean接口的Bean
                如果不是，调用getBean创建对象
                getBean()
                    1.doGetBean(name,null,null,false)
                    2.先获取缓存中保存的单实例Bean，如果能获得到说明这个Bean之前被创建过
                    3.缓存中获取不到，开始Bean的创建对象流程
                    4.标记当前bean已经被创建
                    5.获取Bean的定义信息
                    6.获取当前Bean的依赖其他的bean,如果有按照getBean的方式，把依赖的Bean先创建出来
                    7.启动单实例bean的创建流程
                        createBean(beanName,mbd,args)
                        Object bean = resolveBeforeInstantiation(beanName,mbdToUse)，让BeanPostProcess拦截
                        如果前面的没有返回代理对象
                        调用Object beanInstance = doCreateBean(beanName,mbdToUse,args);
                            创建Bean实例，createBeanInstance(beanName,mbd,args)
                            applyMergedBeanDefinitionPostProcessors(mbd,beanType,beanName)
                            populateBean(beanName,mbd,instanceWrapper)为Bean属性赋值
                            initializeBean(beanName,exposedObject,mbd)
    12.finishRefresh()完成BeanFactory的初始化创建工作，IOC容器创建完成
        12.1 initLifecycleProcessor()初始化和生命周期有关的后置处理器
            查看是否有lifecycleProcessor组件，LifecycleProcessor,如果没有创建默认的
        12.2 getLifeCycleProcessor().onRefresh()方法
        12.3 发布容器完成事件




  */
@Configuration
@ComponentScan(basePackages = "com.syn.bibiCourse.ext")
public class ExtConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtConfig.class);
        ac.publishEvent(new ApplicationEvent(new String("我发布的事件")){});
        ac.close();
    }
}
