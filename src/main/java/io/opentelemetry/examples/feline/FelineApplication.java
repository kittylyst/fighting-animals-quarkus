/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.feline;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "FelineApplication")
public class FelineApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
