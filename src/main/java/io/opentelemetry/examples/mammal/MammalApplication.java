/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.mammal;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "MammalApplication")
public class MammalApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
