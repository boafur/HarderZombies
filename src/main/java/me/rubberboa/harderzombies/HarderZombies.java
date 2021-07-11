package me.rubberboa.harderzombies;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HarderZombies implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "harderzombies";

	@Override
	public void onInitialize() {
		LOGGER.info("Mod has initialized successfully.");
	}
}
