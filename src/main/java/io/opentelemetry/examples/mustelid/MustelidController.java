/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.mustelid;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/mustelid")
@Produces("text/plain")
public class MustelidController {
    private final List<String> MUSTELIDS = List.of("otter", "badger", "marten", "weasel");
    private final Counter numCombatants;

    private final MeterRegistry registry;

    public MustelidController(MeterRegistry registry) {
        this.registry = registry;
        this.numCombatants =
                Counter.builder("battles.combatants").tag("type", "mustelid").register(this.registry);

        new ProcessorMetrics().bindTo(this.registry);
        new JvmMemoryMetrics().bindTo(this.registry);
    }

    @GET
    @Path("/getAnimal")
    public String getAnimal() throws InterruptedException {
        // Random pause
        Thread.sleep((int) (20 * Math.random()));
        numCombatants.increment();

        // Return random mustelid
        return MUSTELIDS.get((int) (MUSTELIDS.size() * Math.random()));
    }
}
