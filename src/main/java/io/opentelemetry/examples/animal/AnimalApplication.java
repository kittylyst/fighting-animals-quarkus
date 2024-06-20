/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.animal;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "AnimalApplication")
public class AnimalApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}