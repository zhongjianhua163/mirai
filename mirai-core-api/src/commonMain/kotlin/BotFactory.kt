/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 *  此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 *  Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 *  https://github.com/mamoe/mirai/blob/master/LICENSE
 */

@file:Suppress("FunctionName", "INAPPLICABLE_JVM_NAME", "DEPRECATION_ERROR", "DeprecatedCallableAddReplaceWith")

package net.mamoe.mirai

import net.mamoe.mirai.utils.BotConfiguration
import net.mamoe.mirai.utils.Context
import net.mamoe.mirai.utils.SinceMirai
import kotlin.jvm.JvmName
import kotlin.jvm.JvmSynthetic

/**
 * 构造 [Bot] 的工厂. 这是 [Bot] 唯一的构造方式.
 *
 * `mirai-core-qqandroid`: `QQAndroid`
 *
 * 在 JVM, 请查看 `BotFactoryJvm`
 */
public expect interface BotFactory {
    /**
     * 使用指定的 [配置][configuration] 构造 [Bot] 实例
     */
    @JvmName("newBot")
    public fun Bot(
        context: Context,
        qq: Long,
        password: String,
        configuration: BotConfiguration = BotConfiguration.Default
    ): Bot

    /**
     * 使用指定的 [配置][configuration] 构造 [Bot] 实例
     */
    @JvmName("newBot")
    public fun Bot(
        context: Context,
        qq: Long,
        passwordMd5: ByteArray,
        configuration: BotConfiguration = BotConfiguration.Default
    ): Bot

    @SinceMirai("1.3.0")
    public companion object INSTANCE : BotFactory
}

/**
 * 使用指定的 [配置][configuration] 构造 [Bot] 实例
 */
@JvmSynthetic
public inline fun BotFactory.Bot(
    context: Context,
    qq: Long,
    password: String,
    configuration: (BotConfiguration.() -> Unit)
): Bot = this.Bot(context, qq, password, BotConfiguration().apply(configuration))

/**
 * 使用指定的 [配置][configuration] 构造 [Bot] 实例
 */
@JvmSynthetic
public inline fun BotFactory.Bot(
    context: Context,
    qq: Long,
    password: ByteArray,
    configuration: (BotConfiguration.() -> Unit)
): Bot = this.Bot(context, qq, password, BotConfiguration().apply(configuration))