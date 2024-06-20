/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.feline;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/feline")
@Produces("text/plain")
public class FelineController {
    private final List<String> CATS = List.of("tabby", "jaguar", "leopard");
    private final MeterRegistry registry;
    private final Counter numCombatants;

    public FelineController(MeterRegistry registry) {
        this.registry = registry;
        this.numCombatants =
                Counter.builder("battles.combatants").tag("type", "feline").register(this.registry);

        new ProcessorMetrics().bindTo(this.registry);
        new JvmMemoryMetrics().bindTo(this.registry);
    }

    @GET
    @Path("/getAnimal")
    public String getAnimal() throws InterruptedException {
        // Random pause
        Thread.sleep((int) (20 * Math.random()));
        numCombatants.increment();
        // Return random cat
        return CATS.get((int) (CATS.size() * Math.random()));
    }
}
