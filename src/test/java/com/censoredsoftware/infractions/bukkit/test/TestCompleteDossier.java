/*
 * Copyright (c) 2014 Alexander Chauncey
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.censoredsoftware.infractions.bukkit.test;

import com.censoredsoftware.infractions.bukkit.Infraction;
import com.censoredsoftware.infractions.bukkit.dossier.CompleteDossier;
import com.google.common.collect.Sets;
import org.bukkit.OfflinePlayer;

import java.net.InetAddress;
import java.util.Set;
import java.util.UUID;

public class TestCompleteDossier extends TestDossier implements CompleteDossier
{
	private String lastKnownName;
	private Set<InetAddress> ipAddresses;

	public TestCompleteDossier(UUID mojangId, String lastKnownName, Infraction... infractions)
	{
		this(mojangId, lastKnownName, Sets.newHashSet(infractions));
	}

	public TestCompleteDossier(UUID mojangId, String lastKnownName, Set<Infraction> infractions)
	{
		super(mojangId, infractions);
		this.lastKnownName = lastKnownName;
		this.ipAddresses = Sets.newHashSet();
	}

	@Override
	public OfflinePlayer getOfflinePlayer() throws IllegalStateException
	{
		throw new IllegalStateException("This is a test case, no server is running.");
	}

	@Override
	public String getLastKnownName()
	{
		return lastKnownName;
	}

	@Override public Set<InetAddress> getAssociatedIPAddresses()
	{
		return ipAddresses;
	}

	@Override
	public CompleteDossier complete(String playerName)
	{
		return this;
	}

	@Override
	public CompleteDossier complete()
	{
		return this;
	}
}
