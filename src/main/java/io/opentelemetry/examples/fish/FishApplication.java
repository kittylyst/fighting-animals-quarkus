/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.fish;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "FishApplication")
public class FishApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
