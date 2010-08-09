/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.infinispan.lucene;

import java.io.Serializable;

/**
 * Used as a key to distinguish file chunk in cache.
 * 
 * @since 4.0
 * @author Lukasz Moren
 * @author Sanne Grinovero
 */
final class ChunkCacheKey implements Serializable {

   /** The serialVersionUID */
   private static final long serialVersionUID = 4429712073623290126L;
   
   private final int chunkId;
   private final String indexName;
   private final String fileName;
   private final int hashCode;

   public ChunkCacheKey(String indexName, String fileName, int chunkId) {
      this.indexName = indexName;
      this.fileName = fileName;
      this.chunkId = chunkId;
      this.hashCode = generatedHashCode();
   }

   /**
    * Get the chunkId.
    * 
    * @return the chunkId.
    */
   public int getChunkId() {
      return chunkId;
   }

   /**
    * Get the indexName.
    * 
    * @return the indexName.
    */
   public String getIndexName() {
      return indexName;
   }

   /**
    * Get the fileName.
    * 
    * @return the fileName.
    */
   public String getFileName() {
      return fileName;
   }
   
   @Override
   public int hashCode() {
      return hashCode;
   }

   private int generatedHashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + chunkId;
      result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
      result = prime * result + ((indexName == null) ? 0 : indexName.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (ChunkCacheKey.class != obj.getClass())
         return false;
      ChunkCacheKey other = (ChunkCacheKey) obj;
      if (chunkId != other.chunkId)
         return false;
      if (fileName == null) {
         if (other.fileName != null)
            return false;
      } else if (!fileName.equals(other.fileName))
         return false;
      if (indexName == null) {
         if (other.indexName != null)
            return false;
      } else if (!indexName.equals(other.indexName))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "ChunkCacheKey{chunkId=" + chunkId + ", fileName=" + fileName + ", indexName=" + indexName + "} ";
   }
   
}
