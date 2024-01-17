<template>
  <div id="brand">
        <img v-on:click="goHome()" id="logo" src="../images/byosmall.png">
        <div>
            <h1 v-on:click="goHome()" id="with-line">Pathway Pizza</h1>
            <p>This is the way</p>
        </div>
    </div>
</template>
    
<script>

const brandGreenColor = '#5FA873';

export default {
    methods:{
        goHome(){
            this.$router.push({name: 'home'});
        }
    }

}
</script>

<style scoped>
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}

:root{
    --brand-green-color: #5FA873;
    --brand-brown-color: #A18F63;
    --brand-lightred-color: #AC685B;
    --brand-darkred-color: #BB554A;
    --brand-white-color: #FFFFFF;
}
*{
    font-family: 'Mandalore Laser Title';
}
#with-line{
    border-bottom: #A18F63 5px solid;
}
h1{
    color: #5FA873;
}
p{
    color: #BB554A;
    letter-spacing: -.2em;
}
#logo{
    width: 100px;
    
}
#brand{
    display: flex;
    border-bottom: #5FA873 5px solid;
}
</style>