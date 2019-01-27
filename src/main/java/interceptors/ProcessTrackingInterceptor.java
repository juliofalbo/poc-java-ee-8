package interceptors;

import annotations.Tracked;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.function.Function;

@Interceptor
//Only need if you created a CustomInterceptor
@Tracked(ProcessTracker.Category.UNUSED)
//You can configure this interceptor in beans.xml too
@Priority(Interceptor.Priority.APPLICATION)
public class ProcessTrackingInterceptor {

    @Inject
    private ProcessTracker processTracker;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext invocationContext) throws Exception {
        //Only need if you created a CustomInterceptor
        Tracked annotation = getAnnotation(invocationContext);
        processTracker.track(annotation.value());
        return invocationContext.proceed();
    }

    //Only need if you created a CustomInterceptor
    private Tracked getAnnotation(InvocationContext invocationContext) {
        Function<AnnotatedElement, Tracked> extractor = context -> context.getAnnotation(Tracked.class);
        Method method = invocationContext.getMethod();
        Tracked annotation = extractor.apply(method);
        return annotation != null ? annotation : extractor.apply(method.getDeclaringClass());
    }

}
