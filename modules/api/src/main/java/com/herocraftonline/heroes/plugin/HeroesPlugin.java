package com.herocraftonline.heroes.plugin;

import com.herocraftonline.heroes.characters.CharacterDamageManager;
import com.herocraftonline.heroes.characters.CharacterEffectManager;
import com.herocraftonline.heroes.characters.CharacterManager;
import com.herocraftonline.heroes.characters.classes.HeroClassManager;
import com.herocraftonline.heroes.characters.party.PartyManager;
import com.herocraftonline.heroes.command.CommandHandler;
import com.herocraftonline.heroes.configuration.ConfigManager;
import com.herocraftonline.heroes.io.StorageManager;
import com.herocraftonline.heroes.skills.SkillConfigManager;
import com.herocraftonline.heroes.skills.SkillManager;

public interface HeroesPlugin {

    /**
     * <p>Gets the active {@link CharacterManager}, which is responsible for loading, managing, retrieving, and saving
     * {@link com.herocraftonline.heroes.characters.HCharacter} instances</p>
     */
    CharacterManager getCharacterManager();

    HeroClassManager getClassManager();

    CommandHandler getCommandHandler();

    ConfigManager getConfigManager();

    CharacterDamageManager getDamageManager();

    CharacterEffectManager getEffectManager();

    String getImplementation();

    PartyManager getPartyManager();

    SkillConfigManager getSkillConfigs();

    SkillManager getSkillManager();

    StorageManager getStorageManager();

    //getPartyChannelManager() TODO

}
