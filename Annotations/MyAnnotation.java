package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * SOURCE: Annotations are retained only in the source code and are discarded by
 * the compiler. They are not available in the compiled bytecode and thus cannot
 * be accessed at runtime.
 * 
 * CLASS: Annotations are retained in the compiled bytecode by the compiler but
 * are not available at runtime. This is the default retention policy if none is
 * specified.
 * 
 * RUNTIME: Annotations are retained in the compiled bytecode and are available
 * at runtime via reflection. This is useful for annotations that need to be
 * accessed during the execution of a program.
 */
@Retention(RetentionPolicy.RUNTIME) // This makes the annotation available at runtime
public @interface MyAnnotation {
    String value();

    int number() default 0;
}
