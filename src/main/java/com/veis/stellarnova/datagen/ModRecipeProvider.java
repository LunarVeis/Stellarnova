package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.block.ModBlocks;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Lists
        List<ItemLike> NOVA_SMELTABLES = List.of(ModBlocks.NOVA_ORE, ModItems.NOVA_CLUSTER, ModItems.NOVA_APPLE);
        List<ItemLike> SIGHTLESS_SMELTABLES = List.of(ModItems.SIGHTLESS_EYE);


        //temp
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STARSEER_ESSENCE.get())
                .requires(Items.COBBLESTONE)
                .requires(ModItems.STARSEER_EYE)
                .requires(Items.IRON_INGOT)
                .requires(ModItems.NOVA_INGOT)
                .requires(Items.GOLD_INGOT)
                .unlockedBy("has_starseer_eye", has(ModItems.STARSEER_EYE.get()))
                .save(recipeOutput);


        //Tools/Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVA_PICKAXE.get())
                .pattern("NNN")
                .pattern(" S ")
                .pattern(" S ")
                .define('N', ModItems.NOVA_INGOT.get()).define('S', Items.STICK)
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVA_AXE.get())
                .pattern("NN ")
                .pattern("NS ")
                .pattern(" S ")
                .define('N', ModItems.NOVA_INGOT.get()).define('S', Items.STICK)
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVA_HOE.get())
                .pattern("NN ")
                .pattern(" S ")
                .pattern(" S ")
                .define('N', ModItems.NOVA_INGOT.get()).define('S', Items.STICK)
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVA_SHOVEL.get())
                .pattern(" N ")
                .pattern(" S ")
                .pattern(" S ")
                .define('N', ModItems.NOVA_INGOT.get()).define('S', Items.STICK)
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVA_SWORD.get())
                .pattern(" N ")
                .pattern(" N ")
                .pattern(" S ")
                .define('N', ModItems.NOVA_INGOT.get()).define('S', Items.STICK)
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                .pattern("  I")
                .pattern(" I ")
                .pattern("S  ")
                .define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STARSEER_BREAKER.get())
                .pattern("IEI")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', ModItems.STELLARNOVA_INGOT.get()).define('E', ModItems.STARSEER_EYE.get()).define('S', Items.STICK)
                .unlockedBy("has_stellarnova_ingot", has(ModItems.STELLARNOVA_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STARSEER_EYE.get())
                .pattern("SDS")
                .pattern("DED")
                .pattern("SDS")
                .define('S', Items.STONE_BRICKS)
                .define('D', Items.DIAMOND)
                .define('E', Items.ENDER_EYE)
                .unlockedBy("has_stellarnova_ingot", has(ModItems.STELLARNOVA_INGOT))
                .save(recipeOutput);

        //Blocks/Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVA_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.NOVA_INGOT.get())
                .unlockedBy("has_nova_ingot", has(ModItems.NOVA_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLARNOVA_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.STELLARNOVA_INGOT.get())
                .unlockedBy("has_nova_ingot", has(ModItems.STELLARNOVA_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLARNOVA_CATALYST.get())
                .pattern("ONO")
                .pattern("NEN")
                .pattern("ONO")
                .define('O', Blocks.OBSIDIAN)
                .define('N', ModBlocks.NOVA_BLOCK.get())
                .define('E', ModItems.STARSEER_EYE.get())
                .unlockedBy("has_nova_block", has(ModBlocks.NOVA_BLOCK))
                .save(recipeOutput);

        //Ingots/Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NOVA_INGOT.get(), 9)
                .requires(ModBlocks.NOVA_BLOCK)
                .unlockedBy("has_nova_block", has(ModBlocks.NOVA_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STELLARNOVA_INGOT.get(), 9)
                .requires(ModBlocks.STELLARNOVA_BLOCK)
                .unlockedBy("has_stellarnova_block", has(ModBlocks.STELLARNOVA_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NOVA_INGOT.get())
                .requires(ModBlocks.STARSEER_ESSENCE)
                .unlockedBy("has_starseer_essence", has(ModBlocks.STARSEER_ESSENCE)).save(recipeOutput, "stellarnova:nova_ingot_from_starseer");

        //Smelting/All
        oreSmelting(recipeOutput, NOVA_SMELTABLES, RecipeCategory.MISC, ModItems.NOVA_INGOT, 0.5f, 200, "nova_ingot");
        oreBlasting(recipeOutput, NOVA_SMELTABLES, RecipeCategory.MISC, ModItems.NOVA_INGOT, 0.5f, 200, "nova_ingot");
        oreSmelting(recipeOutput, SIGHTLESS_SMELTABLES, RecipeCategory.MISC, ModItems.STARSEER_EYE, 0.5f, 200, "STARSEER_EYE");

    }
        //Smelting/Methods
        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTime, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(recipeOutput, Stellarnova.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }
        }





    }
