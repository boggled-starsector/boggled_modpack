package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.util.Misc;

public class Olympians extends BaseHullMod {

	private static final float SHIELD_BONUS = 40f;
	private static final float CAPACITY_MULT = 1.2f;
	private static final float DISSIPATION_MULT = 1.2f;
	
	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id)
	{
		//40% better shield efficiency
		stats.getShieldDamageTakenMult().modifyMult(id, 1f - SHIELD_BONUS * 0.01f);

		//10% better flux stats
		stats.getFluxCapacity().modifyMult(id, CAPACITY_MULT);
		stats.getFluxDissipation().modifyMult(id, DISSIPATION_MULT);
	}
	
	public String getDescriptionParam(int index, HullSize hullSize)
	{
		if (index == 0) return "40%";
		if (index == 1) return "20%";
		return null;
	}
}
