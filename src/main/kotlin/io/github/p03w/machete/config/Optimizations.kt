package io.github.p03w.machete.config

import org.gradle.api.provider.Property

@Suppress("LeakingThis")
abstract class Optimizations {
    /**
     * If nested jar file optimizations should be applied
     */
    abstract val jarInJar: Property<Boolean>

    /**
     * If png file optimizations should be applied
     */
    abstract val png: Property<Boolean>

    /**
     * If json file optimizations should be applied
     */
    abstract val json: Property<Boolean>

    /**
     * If the local variable table should be stripped
     *
     * Lossy on JVM 14+ as this table is used in the "helpful NPE messages" functionality
     *
     * [https://openjdk.java.net/jeps/358](https://openjdk.java.net/jeps/358)
     */
    abstract val stripLVT: Property<Boolean>

    init {
        jarInJar.convention(true)
        png.convention(true)
        json.convention(true)

        // Lossy
        stripLVT.convention(false)
    }
}
