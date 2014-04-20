package com.censoredsoftware.infractions.bukkit;

import com.censoredsoftware.infractions.bukkit.dossier.CompleteDossier;
import com.censoredsoftware.infractions.bukkit.dossier.Dossier;
import com.censoredsoftware.infractions.bukkit.evidence.Evidence;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

/**
 * Interface representing the database holding the dossiers, infractions, and evidence.
 */
public interface Database
{
	/**
	 * Get the CompleteDossier from the Mojang UUID of a player.
	 *
	 * @param playerId The Mojang UUID.
	 * @return The CompleteDossier.
	 * @throws NullPointerException when no CompleteDossier exists.
	 */
	CompleteDossier getCompleteDossier(UUID playerId) throws NullPointerException;

	/**
	 * Get the CompleteDossier from the last known of a player.
	 * The implementation may attempt to create a new Dossier if none exists.
	 *
	 * @param playerName The last known name of the player.
	 * @return The CompleteDossier.
	 * @throws NullPointerException if the CompleteDossier already exists but the UUID does not match.
	 */
	CompleteDossier getCompleteDossier(String playerName) throws NullPointerException;

	/**
	 * Get the CompleteDossier from the Player.
	 *
	 * @param player The Bukkit Player object.
	 * @return The CompleteDossier.
	 */
	CompleteDossier getCompleteDossier(Player player);

	/**
	 * Get the Dossier from the Mojang UUID of a player.
	 *
	 * @param playerId The Mojang UUID.
	 * @return The Dossier.
	 */
	Dossier getDossier(UUID playerId);

	/**
	 * Get the Dossier from the Mojang UUID of a player.
	 * The implementation may attempt to create a new Dossier if none exists.
	 *
	 * @param playerName The last known name of the player.
	 * @return The Dossier.
	 * @deprecated The data returned from this method WILL BE WRONG if a player changes their name.
	 */
	@Deprecated() Dossier getDossier(String playerName);

	/**
	 * Add a dossier to the database.
	 * @param dossier The dossier.
	 */
	void addDossier(Dossier dossier);

	/**
	 * Remove a dossier from the database.
	 *
	 * @param dossier The dossier.
	 */
	void removeDossier(Dossier dossier);

	/**
	 * Remove a dossier from the database.
	 *
	 * @param playerId The player Mojang id.
	 */
	void removeDossier(UUID playerId);

	/**
	 * The Set of all Dossiers.
	 *
	 * @return All Dossiers.
	 */
	Set<Dossier> allDossiers();

	/**
	 * The Set of all Infractions.
	 *
	 * @return All Infractions.
	 */
	Set<Infraction> allInfractions();

	/**
	 * The Set of all Evidence.
	 *
	 * @return All Evidence.
	 */
	Set<Evidence> allEvidence();

	/**
	 * Return the plugin implementing the API.
	 *
	 * @return The plugin.
	 */
	Plugin getPlugin();
}