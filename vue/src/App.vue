<template>
<div>
 <Header/>
</div> <router-view/>
    <Bottom/>
</template>

<style>
</style>
<script>
import Header from "@/components/Header";
import Bottom from "@/components/Bottom";
export default {
 name:"Layout",
 components:{
  Header,
  Bottom
 }
}
</script>
