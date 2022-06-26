package com.saize.genshinassistant.data

import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = RealmList::class)
class RealmListSerializer<T>(elementSerializer: KSerializer<T>) : KSerializer<RealmList<T>> {

    private val listSerializer = ListSerializer(elementSerializer)

    override fun deserialize(decoder: Decoder): RealmList<T> =
        decoder.decodeSerializableValue(listSerializer).toRealmList()

    override val descriptor: SerialDescriptor = SerialDescriptor("RealmList", listSerializer.descriptor)

    override fun serialize(encoder: Encoder, value: RealmList<T>) =
        encoder.encodeSerializableValue(listSerializer, value.toList())
}